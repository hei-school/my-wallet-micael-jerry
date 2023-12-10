require_relative '../model/document'
require_relative '../model/document_type'
require_relative '../model/types/result'
require_relative '../view/bar_view'

def print_document(document_list)
  document_list.each_with_index do |document, i|
    puts "N: #{i + 1}\tidentifier: #{document.id}"
  end
end

def get_document_by_type(document_list, document_type)
  document_list.select { |document| document.type == document_type }
end

def print_document_group_by_type(document_list)
  cin_list = get_document_by_type(document_list, DocumentType::CIN)
  driving_licence_list = get_document_by_type(document_list, DocumentType::DRIVING_LICENCE)
  bank_card_list = get_document_by_type(document_list, DocumentType::BANK_CARD)

  bar("CIN") if cin_list.any?
  print_document(cin_list) if cin_list.any?

  bar("Driving Licence") if driving_licence_list.any?
  print_document(driving_licence_list) if driving_licence_list.any?

  bar("Bank Card") if bank_card_list.any?
  print_document(bank_card_list) if bank_card_list.any?
end

def add_document(document_list)
  document = Document.new
  puts "Document type:\n\t1. CIN\n\t2. Driving Licence\n\t3. Bank Card\n"
  input_type = gets.chomp
  if input_type.match?(/\A\d+\z/) && (1..3).cover?(input_type.to_i)
    puts "Document identifier: "
    input_identifier = gets.chomp
    if !input_identifier.empty?
      document.id = input_identifier
      document.type = type_from_number(input_type.to_i)
      document_list << document
      Result.new(true, "Document added successfully")
    else
      Result.new(false, "Invalid Input - retry")
    end
  else
    Result.new(false, "Invalid Input - retry")
  end
end

def remove_document_in_list(document_list, document)
  document_list.delete(document)
end

def remove_document(documents)
  print_document_group_by_type(documents)
  puts "Type of document you want to remove:\n\t1. CIN\n\t2. Driving Licence\n\t3. Bank Card:\n"
  type_doc_remove_input = gets.chomp
  if type_doc_remove_input.match?(/\A\d+\z/) && (1..3).cover?(type_doc_remove_input.to_i)
    type_doc_remove = type_from_number(type_doc_remove_input.to_i)
    puts "Document number (N): "
    index_doc_remove_input = gets.chomp
    if index_doc_remove_input.match?(/\A\d+\z/)
      index_doc_remove = index_doc_remove_input.to_i
      documents_by_type = get_document_by_type(documents, type_doc_remove)
      if documents_by_type.length >= index_doc_remove
        document_removed = documents_by_type[index_doc_remove - 1]
        remove_document_in_list(documents, document_removed)
        Result.new(true, "Document removed successfully")
      else
        Result.new(false, "Invalid Input - retry")
      end
    else
      Result.new(false, "Invalid Input - retry")
    end
  else
    Result.new(false, "Invalid Input - retry")
  end
end

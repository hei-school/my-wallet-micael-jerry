require_relative '../model/types/result'
require_relative '../view/bar_view'
require_relative '../view/menu_view'
require_relative '../service/document_service.rb'

def run_document_app(document_list)
  condition_running = true
  while condition_running
    print_menu('Status', 'Add', 'Remove', 'Exit')
    input_str = gets.chomp

    choice = input_str.to_i
    case choice
    when 1
      bar('Status')
      print_document_group_by_type(document_list)
    when 2
      bar('Add')
      res = add_document(document_list)
      puts res.message
    when 3
      bar('Remove')
      res = remove_document(document_list)
      puts res.message
    when 4
      condition_running = false
    else
      puts 'RETRY'
    end
  end
end

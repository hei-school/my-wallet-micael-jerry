class DocumentType
  CIN = 0
  DRIVING_LICENCE = 1
  BANK_CARD = 2
  NONE = 3
end

def type_from_number(n)
  case n
  when 1 then DocumentType::CIN
  when 2 then DocumentType::DRIVING_LICENCE
  when 3 then DocumentType::BANK_CARD
  else DocumentType.NONE
  end
end

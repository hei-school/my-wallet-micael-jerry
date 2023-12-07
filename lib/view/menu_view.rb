require_relative 'bar_view'

def print_menu(*menu)
  bar("Menu")
  menu.each_with_index do |item, index|
    puts "#{index + 1}. #{item}"
  end
end

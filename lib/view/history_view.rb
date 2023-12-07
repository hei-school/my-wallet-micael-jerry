require_relative '../model/history'
require_relative 'bar_view'

def print_history(history_list)
  bar("History")
  if history_list.empty?
    puts "Empty history"
    return
  end
  history_list.each_with_index do |history, index|
    puts "#{index + 1}. #{history.timestamp} - operation: #{history.operation} - sold: #{history.wallet.sold}"
  end
end

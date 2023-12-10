require_relative '../model/types/result'
require_relative '../model/wallet'
require_relative '../view/bar_view'
require_relative '../view/menu_view'
require_relative './money_app'
require_relative './document_app'

def run
  wallet = Wallet.new

  puts 'Welcome'

  condition_running = true
  while condition_running
    print_menu('Money','Document', 'Exit')
    input_str = gets.chomp

    choice = input_str.to_i
    case choice
    when 1
      run_money_app(wallet.money)
    when 2
      run_document_app(wallet.documents)
    when 3
      condition_running = false
      puts 'Bye'
    else
      puts 'RETRY'
    end
  end
end

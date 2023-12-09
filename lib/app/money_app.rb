require_relative '../model/types/result'
require_relative '../model/wallet'
require_relative '../view/bar_view'
require_relative '../view/menu_view'
require_relative '../service/money_service'

def run_money_app(money)
  condition_running = true
  while condition_running
    print_menu('Status', 'Deposit', 'Withdraw', 'Exit')
    input_str = gets.chomp

    choice = input_str.to_i
    case choice
    when 1
      bar('Status')
      print_money(money)
    when 2
      bar('Deposit')
      res = deposit(money)
      puts res.message
    when 3
      bar('Withdraw')
      res = withdrawal(money)
      puts res.message
    when 4
      condition_running = false
      puts 'Bye'
    else
      puts 'RETRY'
    end
  end
end

require_relative 'model/history'
require_relative 'model/operation_type'
require_relative 'model/types/result'
require_relative 'model/wallet'
require_relative 'service/wallet_service'
require_relative 'view/bar_view'
require_relative 'view/history_view'
require_relative 'view/menu_view'

def run
  wallet = Wallet.new
  history_list = []

  puts 'Welcome'

  condition_running = true
  while condition_running
    print_menu('Status', 'Deposit', 'Withdraw', 'History', 'Exit')
    input_str = gets.chomp

    choice = input_str.to_i
    case choice
    when 1
      bar('Status')
      print_wallet(wallet)
      history_list << History.new(OperationType::STATUS, wallet)
    when 2
      bar('Deposit')
      res = deposit(wallet)
      if res.is_success
        puts res.message
        history_list << History.new(OperationType::DEPOSIT, wallet)
      else
        puts res.message
      end
    when 3
      bar('Withdraw')
      res = withdrawal(wallet)
      if res.is_success
        puts res.message
        history_list << History.new(OperationType::WITHDRAW, wallet)
      else
        puts res.message
      end
    when 4
      print_history(history_list)
    when 5
      condition_running = false
      puts 'Bye'
    else
      puts 'RETRY'
    end
  end
end

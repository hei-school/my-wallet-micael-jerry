require_relative '../model/types/result'
require_relative '../model/money'

def print_money(money)
  puts "Money:"
  puts "\tsold: #{money.sold}"
end

def deposit(money)
  print "Money to deposit: "
  input_str = gets.chomp

  begin
    input_int = Integer(input_str)
    money.sold = input_int
    Result.new(true, "Deposit successfully", money)
  rescue ArgumentError, TypeError
    Result.new(false, "Invalid Input - retry", input_str)
  end
end

def withdrawal(money)
  print "Amount to withdraw: "
  input_str = gets.chomp

  begin
    input_int = Integer(input_str)
    if input_int > money.sold
      Result.new(false, "Insufficient balance", input_int)
    else
      money.sold -= input_int
      Result.new(true, "Withdrawal successfully", money)
    end
  rescue ArgumentError, TypeError
    Result.new(false, "Invalid Input - retry", input_str)
  end
end

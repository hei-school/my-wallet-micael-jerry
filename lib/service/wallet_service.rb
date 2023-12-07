require_relative '../model/types/result'
require_relative '../model/wallet'

def print_wallet(wallet)
  puts "Wallet:"
  puts "  sold: #{wallet.sold}"
end

def deposit(wallet)
  print "Money to deposit: "
  input_str = gets.chomp

  begin
    input_int = Integer(input_str)
    wallet.sold = input_int
    Result.new(true, "Deposit successfully", wallet)
  rescue ArgumentError, TypeError
    Result.new(false, "Invalid Input - retry", input_str)
  end
end

def withdrawal(wallet)
  print "Amount to withdraw: "
  input_str = gets.chomp

  begin
    input_int = Integer(input_str)
    if input_int > wallet.sold
      Result.new(false, "Insufficient balance", input_int)
    else
      wallet.sold -= input_int
      Result.new(true, "Withdrawal successfully", wallet)
    end
  rescue ArgumentError, TypeError
    Result.new(false, "Invalid Input - retry", input_str)
  end
end

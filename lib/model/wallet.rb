require_relative './money'

class Wallet
  def initialize
    @money = Money.new
  end

  def money
    @money
  end

  def money=(new_money)
    @money = new_money
  end
end

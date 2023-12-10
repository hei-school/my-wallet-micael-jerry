require_relative './money'

class Wallet
  def initialize
    @money = Money.new
    @documents = []
  end

  attr_accessor :money, :documents
end

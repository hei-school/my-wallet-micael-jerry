require 'date'
require_relative 'operation_type'
require_relative 'wallet'

class History
  attr_reader :timestamp, :operation, :wallet

  def initialize(operation, wallet)
    @timestamp = DateTime.now
    @operation = operation
    @wallet = wallet
  end

  def operation=(new_operation)
    @operation = new_operation
  end

  def wallet=(new_wallet)
    @wallet = new_wallet
  end
end

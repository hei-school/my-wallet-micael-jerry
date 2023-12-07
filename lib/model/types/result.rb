class Result
  attr_accessor :is_success, :message, :data

  def initialize(is_success, message = nil, data = nil)
    @is_success = is_success
    @message = message
    @data = data
  end
end

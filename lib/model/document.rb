require_relative './document_type'

class Document
  def initialize
    @type = nil
    @id = nil
  end

  attr_accessor :type, :id
end

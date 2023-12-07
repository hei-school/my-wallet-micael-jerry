class Result:
    def __init__(self, is_success: bool, message: str = None, data=None):
        self.__is_success: bool = is_success
        self.__message: str = message
        self.__data = data

    @property
    def is_success(self) -> bool:
        return self.__is_success

    @is_success.setter
    def is_success(self, is_success: bool) -> None:
        self.__is_success = is_success

    @property
    def message(self) -> str:
        return self.__message

    @message.setter
    def message(self, message: str) -> None:
        self.__message = message

    @property
    def data(self):
        return self.__data

    @data.setter
    def data(self, data):
        self.__data = data

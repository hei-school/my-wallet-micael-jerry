class Wallet:
    def __init__(self):
        self.__sold: int = 0

    @property
    def sold(self):
        return self.__sold

    @sold.setter
    def sold(self, sold: int):
        self.__sold = sold

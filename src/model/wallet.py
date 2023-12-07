class Wallet:
    def __init__(self, sold: int = 0):
        self.__sold: int = sold

    @property
    def sold(self):
        return self.__sold

    @sold.setter
    def sold(self, sold: int):
        self.__sold = sold

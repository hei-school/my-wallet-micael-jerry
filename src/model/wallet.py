from src.model.money import Money


class Wallet:
    def __init__(self):
        self.__money: Money = Money()

    @property
    def money(self) -> Money:
        return self.__money

    @money.setter
    def money(self, money: Money) -> None:
        self.__money = money

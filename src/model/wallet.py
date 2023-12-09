from src.model.document import Document
from src.model.money import Money


class Wallet:
    def __init__(self):
        self.__money: Money = Money()
        self.__documents: list[Document] = []

    @property
    def money(self) -> Money:
        return self.__money

    @money.setter
    def money(self, money: Money) -> None:
        self.__money = money

    @property
    def documents(self) -> list[Document]:
        return self.__documents

    @documents.setter
    def documents(self, documents: list[Document]) -> None:
        self.__documents = documents

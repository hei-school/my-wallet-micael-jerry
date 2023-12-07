from datetime import datetime

from src.model.operation_type import OperationType
from src.model.wallet import Wallet


class History:
    def __init__(self, operation: OperationType, wallet: Wallet):
        self.__timestamp: datetime = datetime.now()
        self.__operation: OperationType = operation
        self.__wallet: Wallet = wallet

    @property
    def timestamp(self) -> datetime:
        return self.__timestamp

    @property
    def operation(self) -> OperationType:
        return self.__operation

    @operation.setter
    def operation(self, operation: OperationType) -> None:
        self.__operation = operation

    @property
    def wallet(self) -> Wallet:
        return self.__wallet

    @wallet.setter
    def wallet(self, wallet: Wallet) -> None:
        self.__wallet = wallet

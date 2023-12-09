from enum import Enum


class DocumentType(Enum):
    CIN = 0
    DRIVING_LICENCE = 1
    BANK_CARD = 2
    NONE = 3


def get_type_by_num(n: int) -> DocumentType:
    if n == 1:
        return DocumentType.CIN
    elif n == 2:
        return DocumentType.DRIVING_LICENCE
    elif n == 3:
        return DocumentType.BANK_CARD
    else:
        return DocumentType.NONE

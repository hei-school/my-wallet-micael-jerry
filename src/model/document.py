from src.model.document_type import DocumentType


class Document:
    def __init__(self):
        self.__type: DocumentType | None = None
        self.__id: str | None = None

    @property
    def type(self) -> DocumentType | None:
        return self.__type

    @type.setter
    def type(self, new_type: DocumentType) -> None:
        self.__type = new_type

    @property
    def id(self) -> str | None:
        return self.__id

    @id.setter
    def id(self, new_id: str) -> None:
        self.__id = new_id

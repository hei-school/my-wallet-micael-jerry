import { DocumentType } from "./document.type";

export class Document {
  private type: DocumentType | null;
  private id: string | null;

  constructor() {
    this.type = null;
    this.id = null;
  }

  getType(): DocumentType | null {
    return this.type;
  }

  getId(): string | null {
    return this.id;
  }

  setType(type: DocumentType): void {
    this.type = type;
  }

  setId(id: string): void {
    this.id = id;
  }
}
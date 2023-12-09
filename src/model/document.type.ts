export enum DocumentType {
  CIN,
  DRIVING_LICENCE,
  BANK_CARD,
  NONE
}

export const getTypeByNum = (n: number): DocumentType => {
  if (n == 1) return DocumentType.CIN;
  else if (n == 2) return DocumentType.DRIVING_LICENCE;
  else if (n == 3) return DocumentType.BANK_CARD;
  else return DocumentType.NONE;
};
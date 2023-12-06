export class Wallet {
  sold: number;

  constructor (sold: number) {
    this.sold = sold;
  }

  getSold () {
    return this.sold;
  }

  setSold (sold: number) {
    this.sold = sold;
  }
}
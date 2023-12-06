const printWallet = (wallet: Wallet): void => {
  console.log(`Wallet: \n - sold: ${wallet.getSold()}`);
}

const deposit = (wallet: Wallet): void => {
  const input = myPrompt("Money to deposit: ");
  if (!isNaN(Number(input))) {
    wallet.setSold(wallet.getSold() + Number(input));
    console.log("Deposit successfully");
  } else {
    console.log("Invalid Input - retry");
  }
}

module.exports.printWallet = printWallet;
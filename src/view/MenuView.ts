export const printMenu = (...menu: string[]) => {
  console.log("===================== Menu =====================");
  for (let i = 0; i < menu.length; i++) {
    console.log(i + 1 + ". " + menu[i]);
  }
};

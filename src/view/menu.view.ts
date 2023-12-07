import { bar } from "./bar.view";

export const printMenu = (...menu: string[]) => {
  bar("Menu");
  for (let i = 0; i < menu.length; i++) {
    console.log(i + 1 + ". " + menu[i]);
  }
};

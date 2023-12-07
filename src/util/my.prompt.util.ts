const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const scanner = async (question: string): Promise<unknown> => {
  return new Promise((resolve) => {
    rl.question(question, (response: string) => {
      resolve(response);
    });
  });
}

export const myPrompt = async (question: string): Promise<unknown> => {
  let res = await scanner(question);
  return res;
}

export const closeMyPrompt = () => {
  rl.close();
}
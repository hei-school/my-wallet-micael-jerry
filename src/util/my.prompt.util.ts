const readline = require("readline")

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const scanner = (question: string): Promise<unknown> => {
  return new Promise((resolve) => {
    rl.question(question, (response: string) => {
      resolve(response);
    });
  });
}

const myPrompt = async (question: string): Promise<unknown> => {
  let res: Promise<unknown> = scanner(question);
  rl.close();
  return res;
}

module.exports.myPrompt = myPrompt;
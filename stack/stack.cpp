String infix_to_postfix(const char expr[]){
  stack<String> S;
  int i =0;
  String left, right, op, token;

  while(expr[i] != 0){
    token = expr[i];
    if(token == ")"){
      right = S.pop();
      op = S.pop();
      left = S.pop();
      S.push(left + op + right);
    }
    else if(token != "("){
      S.push(token);
    }
    i++;
  }
  return S.pop();
}

int eval(int lhs, char op, int rhs){
  switch(op){
    case '+': return lhs + rhs;
    case '-': return lhs - rhs;
    case '*':return lhs * rhs;
    case '/': return lhs / rhs;
  }
  return 0;
}

int EvalPostfix(const char expr[]){
  stack<int> S;
  int i = 0;
  int rhs, lhs;
  while(expr[i] != 0){
    token = expr[i];
    if(!isOperand(token)){
      rhs = S.pop();
      lhs = S.pop();
      S.push(eval(lhs, token, rhs));
    }
    else{
      S.push(charToInt(token));
    }
  }
  return S.pop();
}
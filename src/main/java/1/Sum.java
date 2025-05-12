package money;

class Sum implements Expression {
	Expression augend; // 被加算数
	Expression addend; // 加数
	
	Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Expression plus(Expression addend) {
		return null;
	}

	public Money reduce(Bank bank, String to) {
		int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
		return new Money(amount, to);
	}
}


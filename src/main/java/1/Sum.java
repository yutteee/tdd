package money;

class Sum implements Expression {
	Expression augend; // 被加算数
	Expression addend; // 加数
	
	Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

	public Money reduce(Bank bank, String to) {
		int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
		return new Money(amount, to);
	}
	
	public Expression times(int multiplier) {
		return new Sum(augend.times(multiplier), addend.times(multiplier));
	}
}


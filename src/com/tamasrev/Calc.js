function sum(a, b) { return a+b; }

function dividendWithRemainder(full, dividor) {
	var result = {};
	result.remainder = full%dividor;
	result.dividend = (full - result.remainder) / dividor;
	return result;
}
package com.troy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xuboru on 2018/12/17
 */
public class JudgePoint24
{
	static class Fraction
	{
		private int numerator;//分子
		private int denominator;//分母

		private Fraction(int num)
		{
			numerator = num;
			denominator = 1;
		}

		private Fraction(int numerator, int denominator)
		{
			this.numerator = numerator;
			this.denominator = denominator;
		}

		static Fraction add(Fraction fraction1, Fraction fraction2)
		{
			return new Fraction(fraction1.numerator * fraction2.denominator +
					fraction2.numerator * fraction1.denominator
					, fraction1.denominator * fraction2.denominator);
		}

		static Fraction subtract(Fraction fraction1, Fraction fraction2)
		{
			return new Fraction(fraction1.numerator * fraction2.denominator -
					fraction2.numerator * fraction1.denominator
					, fraction1.denominator * fraction2.denominator);
		}

		static Fraction multiply(Fraction fraction1, Fraction fraction2)
		{
			return new Fraction(fraction1.numerator * fraction2.numerator
					, fraction1.denominator * fraction2.denominator);
		}

		static Fraction divide(Fraction fraction1, Fraction fraction2)
		{
			return new Fraction(fraction1.numerator * fraction2.denominator
					, fraction1.denominator * fraction2.numerator);
		}
	}

	public boolean judgePoint24(int[] nums)
	{
		List<Fraction> fractions = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
		{
			fractions.add(new Fraction(nums[i]));
		}

		return compute(fractions);
	}

	public boolean compute(List<Fraction> fractions)
	{
		if (fractions.size() == 1)
		{
			if (fractions.get(0).numerator == fractions.get(0).denominator * 24)
				return true;
			else
				return false;
		}

		int n = fractions.size();
		//选取两个做运算
		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{

				List<Fraction> newList = new ArrayList<>();
				for (int x = 0; x < n; x++)
				{
					if (x != i && x != j)
					{
						newList.add(fractions.get(x));
					}
				}

				newList.add(Fraction.add(fractions.get(i), fractions.get(j)));
				if (compute(newList))
				{
					return true;
				}
				else
				{
					newList.remove(n - 2);
				}

				newList.add(Fraction.subtract(fractions.get(i), fractions.get(j)));
				if (compute(newList))
				{
					return true;
				}
				else
				{
					newList.remove(n - 2);
				}

				newList.add(Fraction.subtract(fractions.get(j), fractions.get(i)));
				if (compute(newList))
				{
					return true;
				}
				else
				{
					newList.remove(n - 2);
				}

				newList.add(Fraction.multiply(fractions.get(i), fractions.get(j)));
				if (compute(newList))
				{
					return true;
				}
				else
				{
					newList.remove(n - 2);
				}

				if (fractions.get(j).numerator != 0)
				{
					newList.add(Fraction.divide(fractions.get(i), fractions.get(j)));
					if (compute(newList))
					{
						return true;
					}
					else
					{
						newList.remove(n - 2);
					}
				}

				if (fractions.get(i).numerator != 0)
				{
					newList.add(Fraction.divide(fractions.get(j), fractions.get(i)));
					if (compute(newList))
					{
						return true;
					}
					else
					{
						newList.remove(n - 2);
					}
				}

			}
		}
		return false;
	}
}

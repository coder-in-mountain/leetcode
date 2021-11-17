import math
class Solution:

    def __init__(self):
        self.under20 = {
            1: 'One',
            2: 'Two',
            3: 'Three',
            4: 'Four',
            5: 'Five',
            6: 'Six',
            7: 'Seven',
            8: 'Eight',
            9: 'Nine',
            10: 'Ten',
            11: 'Eleven',
            12: 'Twelve',
            13: 'Thirteen',
            14: 'Fourteen',
            15: 'Fifteen',
            16: 'Sixteen',
            17: 'Seventeen',
            18: 'Eighteen',
            19: 'Nineteen',
        }
        self.under100 = {
            2: 'Twenty',
            3: 'Thirty',
            4: 'Forty',
            5: 'Fifty',
            6: 'Sixty',
            7: 'Seventy',
            8: 'Eighty',
            9: 'Ninety',
        }

        self.multiplerName = {
            1: ' Hundred',
            2: ' Thousand',
            3: ' Million',
            4: ' Billion',
        }
        self.multiplerUnit = {
            1: 100,
            2: 1000,
            3: 1000000,
            4: 1000000000,
        }
    def numberToWords(self, num: int) -> str:
        return self.toWords('', num)

    def toWords(self, prev: str, num: int) -> str:
        if num == 0:
            return 'Zero' if not prev else prev
        if num < 20:
            return self.under20[num] if not prev else prev + ' ' + self.under20[num]
        if num < 100:
            answer = self.toWords(self.under100[num//10], num % 10)
            return answer if not prev else prev + ' ' + answer

        index = self.getMultiplerIndex(num)
        answer = self.toWords(prev, num//self.multiplerUnit[index]) + self.multiplerUnit[index]
        return self.toWords(answer, num % self.multiplerUnit[index])

    def getMultiplerIndex(self, num: int) -> int:
        n = len(str(num))
        return math.ceil(n/3)
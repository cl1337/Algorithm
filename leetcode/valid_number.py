import re


class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        pattern = "^[\\+\\-]?((\\d+(\\.\\d*)?)|(\\.\\d+))(e[\\+\\-]?\\d+)?$"
        return bool(re.match(pattern, s.strip()))


if __name__ == '__main__':
    cls = Solution()
    test_cases = {
        '0..': False,
        ' -.': False,
        '-1.': True,
        '  ': False,
        '3.': True,
        '.1': True,
        '.': False,
        '0': True,
        '0e': False,
        ' 0.1 ': True,
        '1e.': False,
        'abc': False,
        '1 a': False,
        '2e10': True,
        'e9': False
    }
    for k, v in test_cases.iteritems():
        print '{} {}'.format(k, 'passed' if cls.isNumber(k) == v else 'failed')

class stackSolution:
    """
    The only abnormally case is 'b' followed by 'a'.
    The idea here is to simply push 'b' onto a Stack whenever we encounter it.
    But what if we encounter 'a', in this case we check if there is a 'b' present already only then we pop 'b'
    from the Stack (which signifies a Delete operation).
    """
    def minimumDeletions(self, s: str) -> int:
        stack = []
        count = 0

        for c in s:
            if not stack and c == 'a' and stack[-1] == 'b':
                count += 1
                stack.pop()
            elif c == 'b':
                stack.append(c)
        return count
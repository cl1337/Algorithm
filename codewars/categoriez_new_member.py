def openOrSenior(data):
    # Hmmm.. Where to start?
    return map(lambda x: 'Senior' if x[0] >= 55 and x[1] > 7 else 'Open', data)

if __name__ == '__main__':
    print openOrSenior([[18, 20],[45, 2],[61, 12],[37, 6],[21, 21],[78, 9]])

forest = []
line = open("inputs/day8/allTrees.txt", "r")
for x in line:
    t = list(map(int, x.strip()))
    forest.append(t)

for row in forest:
    print(row)

visable = []

rowLen = len(forest[0])
length = len(forest)

highScore = 0
for i, row in enumerate(forest):
    for j, element in enumerate(row):
        bTopScore = bBottomScore = bLeftScore = bRightScore = 0
        aCurrTree = forest[i][j]

        # checks trees left of current tree
        for k in range(j - 1, -1, -1):
            aTempTree = forest[i][k]
            bLeftScore += 1
            if aCurrTree <= aTempTree:
                break
        
        # checks trees right of current tree
        r = j + 1
        for l in range(r, rowLen):
            aTempTree = forest[i][l]
            bRightScore += 1
            if aCurrTree <= aTempTree:
                break
            
        # checks trees above current tree
        for b in range(i - 1, -1, -1):
            aTempTree = forest[b][j]
            bTopScore += 1
            if aCurrTree <= aTempTree:
                break

        # checks trees below current tree
        x = i + 1
        for f in range(x, length):
            aTempTree = forest[f][j]
            bBottomScore += 1
            if aCurrTree <= aTempTree:
                break

        # add tree if visable from at least one side 
        viewScore = bLeftScore * bRightScore * bTopScore * bBottomScore

        if (viewScore > highScore):
            highScore = viewScore

print(highScore)
        
        


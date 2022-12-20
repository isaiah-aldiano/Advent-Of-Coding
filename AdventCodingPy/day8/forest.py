forest = []
line = open("inputs/day8/allTrees.txt", "r")
for x in line:
    x = x.strip()
    t = list(map(int, x))
    forest.append(t)

visable = []

rowLen = len(forest[0])
length = len(forest)

for i, row in enumerate(forest):
    for j, element in enumerate(row):
        top = bottom = left = right = True
        currTree = forest[i][j]
        b = 0

        if i == 0 or i == len(forest) - 1 or j == 0 or j == len(forest[i]) - 1:
            visable.append(currTree)
        else: 
            # checks trees left of current tree
            for k in range(0, j):
                tempTree = forest[i][k]
                if currTree <= tempTree:
                    left = False
                    break
            
            # checks trees right of current tree
            r = j + 1
            for l in range(r, rowLen):
                tempTree = forest[i][l]
                if currTree <= tempTree:
                    right = False
                    break
                
            # checks trees above current tree
            for b in range(0, i):
                tempTree = forest[b][j]
                if currTree <= tempTree:
                    top = False
                    break

            # checks trees below current tree
            x = i + 1
            for f in range(x, length):
                tempTree = forest[f][j]
                if currTree <= tempTree:
                    bottom = False
                    break

            # add tree if visable from at least one side 
            if left or right or top or bottom:
                visable.append(currTree)

print(len(visable))
        
        


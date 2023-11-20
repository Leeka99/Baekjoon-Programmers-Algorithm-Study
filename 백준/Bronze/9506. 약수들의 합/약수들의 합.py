while True:
    n = int(input())
    if n == -1:
        break
    save = list()
    for i in range(1, n):
       if n % i == 0:
           save.append(i)
    if sum(save) == n:
        print(n, " = ", " + ".join(str(i) for i in save), sep="")
    elif sum != n:
        print(n, "is NOT perfect.")
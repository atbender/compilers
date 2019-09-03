import sys

# check for file argument
if len(sys.argv) < 2:
	print('Error: Requires stack machine compiled code file as argument')
	sys.exit()

file_name = sys.argv[1]


# try to open file
try:
    file = open(file_name, 'r')

except FileNotFoundError:
    print('Error: File does not exist')
    sys.exit()


# check verbose
verbose = False

if len(sys.argv) == 3:
	if sys.argv[2] == '-verbose':
		verbose = True


# initialize machine
stack = []
register = 0


# process lines in file
for line in file:
	tokens = line.split()
	if verbose == True: print('stack: ', end = '')
	if verbose == True: print(stack)

	if tokens[0] == 'PUSH':
		stack.append(tokens[1])
		if verbose == True: print('push ', tokens[1])

	elif tokens[0] == 'SUM':
		register = int(stack.pop())
		register = register + int(stack.pop())
		stack.append(register)
		if verbose == True: print('sum')

	elif tokens[0] == 'SUB':
		register = int(stack.pop())
		register = int(stack.pop()) - register
		stack.append(register)
		if verbose == True: print('sub')

	elif tokens[0] == 'MULT':
		register = int(stack.pop())
		register = register * int(stack.pop())
		stack.append(register)
		if verbose == True: print('mult')

	elif tokens[0] == 'DIV':
		register = int(stack.pop())
		register = (int) (int(stack.pop()) / register)
		stack.append(register)
		if verbose == True: print('div')

	elif tokens[0] == 'PRINT':
		if verbose == True: print('print')
		print(stack.pop())

	else:
		print('Error: Bad file format')
		sys.exit()


# close file
file.close()
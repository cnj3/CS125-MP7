from __future__ import print_function
import random


def thedisplayboard(board):
    print('   |   |')
    print(' ' + board[1] + ' | ' + board[2] + ' | ' + board[3])
    print('   |   |')
    print('-----------')
    print('   |   |')
    print(' ' + board[4] + ' | ' + board[5] + ' | ' + board[6])
    print('   |   |')
    print('-----------')
    print('   |   |')
    print(' ' + board[7] + ' | ' + board[8] + ' | ' + board[9])
    print('   |   |')


def userinput():
    point = ''
    while not (point == 'X' or point == 'O' or point == 'Quit'):
        point = raw_input('Player 1: Would you like to be X or O?').upper()

    if point == 'X':
        return 'X', 'O'
    else:
        return 'O', 'X'


def placepoint(board, point, position):
    board[position] = point


def checkwin(board, mark):
    return((board[1] == mark and board[2] == mark and board[3] == mark) or
    (board[4] == mark and board[5] == mark and board[6] == mark) or
    (board[7] == mark and board[8] == mark and board[9] == mark) or
    (board[1] == mark and board[4] == mark and board[7] == mark) or
    (board[2] == mark and board[5] == mark and board[8] == mark) or
    (board[3] == mark and board[6] == mark and board[9] == mark) or
    (board[3] == mark and board[5] == mark and board[7] == mark) or
    (board[1] == mark and board[5] == mark and board[9] == mark))


def choosefirst():
    if random.randint(0, 1) == 0:
        return 'Player 2'
    else:
        return 'Player 1'


def checkspace(board, position):
    return board[position] == ' '


def checkmainboard(board):
    for i in range(1, 10):
        if checkspace(board, i):
            return False
    return True


def playerchoice(board, point):
    position = ' '
    while position not in '1 2 3 4 5 6 7 8 9'.split() or not checkspace(board, int(position)):
        position = raw_input(point + ' choose your next position: (1-9) ')
    return int(position)


def replay():
    return raw_input('Would you like to play again? ').lower().startswith('y')


print('Welcome to Tic Tac Toe!')


while True:
    mainBoard = [' '] * 10
    player1_point, player2_point = userinput()
    turn = choosefirst()
    print(turn + ' will go first.')
    gameStarted = True

    while gameStarted:
        if turn == 'Player 1':
            thedisplayboard(mainBoard)
            position = playerchoice(mainBoard, turn)
            placepoint(mainBoard, player1_point, position)

            if checkwin(mainBoard, player1_point):
                thedisplayboard(mainBoard)
                print('Great Job! Player 1, you have won the game!')
                gameStarted = False
            else:
                if checkmainboard(mainBoard):
                    thedisplayboard(mainBoard)
                    print('TIE GAME!')
                    break
                else:
                    turn = 'Player 2'

        else:
            thedisplayboard(mainBoard)
            position = playerchoice(mainBoard, turn)
            placepoint(mainBoard, player2_point, position)

            if checkwin(mainBoard, player2_point):
                thedisplayboard(mainBoard)
                print('Great Job! Player 2, you have won the game!')
                gameStarted = False
            else:
                if checkmainboard(mainBoard):
                    thedisplayboard(mainBoard)
                    print('TIE GAME!')
                    break
                else:
                    turn = 'Player 1'

    if not replay():
        break


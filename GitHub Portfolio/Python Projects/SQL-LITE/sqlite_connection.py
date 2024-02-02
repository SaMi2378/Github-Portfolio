import sqlite3
conn = sqlite3.connect ('M:\Desktop\python2022\SQL-LITE\SCHOOL2.db')
cur = conn.cursor()

cur.execute('CREATE TABLE IF NOT EXISTS Students (id INTEGER, name VARCHAR(30))')

cur.execute('INSERT INTO Students (id, name) VALUES (?, ?)',
(25, 'Sami'))

conn.close()

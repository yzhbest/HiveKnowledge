# -*- coding: utf-8 -*-
from pyhive import hive
def main():

    hvhost='192.168.2.9' #主机ip
    hvport=10000           #端口号
    hvauth='NOSASL'       #授权模式

    conn = hive.Connection(host=hvhost, port=hvport,auth=hvauth)
    cursor = conn.cursor()
    cursor.execute('select * from xp limit 10')  # 执行查询
    for result in cursor.fetchall():
        print(result)

if __name__ == '__main__':
    main()
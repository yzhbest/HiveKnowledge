
from sqlalchemy import create_engine

"""
更多参考 https://pypi.org/project/PyHive/
"""
def main():

    hvhost='192.168.2.9' #主机ip
    hvport=10000           #端口号
    hvauth='NOSASL'       #授权模式

    engine = create_engine('hive://'+hvhost+":"+str(hvport), connect_args={'auth':hvauth})
    #创建连接
    connection = engine.connect()
    result = connection.execute('select * from xp;')
    print(result)
    #释放连接
    engine.dispose()

if __name__ == '__main__':
    main()
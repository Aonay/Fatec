from pymongo.mongo_client import MongoClient
from pymongo.server_api import ServerApi
from django.conf import settings

client = MongoClient(settings.MONGO_URI, server_api=ServerApi('1'))
db = client['dbRB']

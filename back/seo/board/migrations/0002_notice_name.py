# Generated by Django 2.2.6 on 2020-01-31 04:45

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('board', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='notice',
            name='name',
            field=models.TextField(default='sht3898'),
            preserve_default=False,
        ),
    ]
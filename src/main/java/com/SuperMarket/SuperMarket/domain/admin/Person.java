package com.SuperMarket.SuperMarket.domain.admin;

import com.SuperMarket.SuperMarket.domain.base.Domain;

public sealed class Person extends Domain permits Client, Employee{
}

package com.Testes.web;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ ClienteTest.class, ProdutoTest.class,  ProprietarioTest.class, ClienteBasicaTest.class})
public class AllTests {

}

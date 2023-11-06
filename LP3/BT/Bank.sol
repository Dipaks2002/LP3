// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount {
    address public owner;
    uint public balance;

    constructor() {
        owner = msg.sender;
        balance = 0;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Only the owner can perform this operation");
        _;
    }

    function deposit(uint amount) public onlyOwner {
        require(amount > 0, "Deposit amount must be greater than 0");
        balance += amount;
    }

    function withdraw(uint amount) public onlyOwner {
        require(amount > 0, "Withdrawal amount must be greater than 0");
        require(balance >= amount, "Insufficient balance");
        balance -= amount;
    }

    function getBalance() public view returns (uint) {
        return balance;
    }
}
/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3moac.crypto;

import java.math.BigInteger;

import org.web3moac.utils.Numeric;

/**
 * Transaction class used for signing transactions locally.<br>
 * For the specification, refer to p4 of the <a href="http://gavwood.com/paper.pdf">yellow
 * paper</a>.
 */
public class RawTransaction {

    private BigInteger nonce;
    private BigInteger gasPrice;
    private BigInteger gasLimit;
    private String to;
    private BigInteger value;
    private String data;
    private BigInteger gasPremium;
    private BigInteger feeCap;
    private BigInteger shardingflag;
    private String via;

    protected RawTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            String data) {
        this(nonce, gasPrice, gasLimit, to, value, data, null, null, BigInteger.ZERO, null);
    }

    protected RawTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            String data,
            BigInteger gasPremium,
            BigInteger feeCap) {
        this(nonce, gasPrice, gasLimit, to, value, data, gasPremium, feeCap, BigInteger.ZERO, null);
    }

    protected RawTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            String data,
            BigInteger gasPremium,
            BigInteger feeCap,
            BigInteger shardingflag,
            String via) {
        this.nonce = nonce;
        this.gasPrice = gasPrice;
        this.gasLimit = gasLimit;
        this.to = to;
        this.value = value;
        this.data = data != null ? Numeric.cleanHexPrefix(data) : null;
        this.gasPremium = gasPremium;
        this.feeCap = feeCap;
        this.shardingflag = shardingflag;
        this.via = via;
    }

    public static RawTransaction createContractTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            BigInteger value,
            String init) {

        return new RawTransaction(nonce, gasPrice, gasLimit, "", value, init);
    }

    public static RawTransaction createContractTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            BigInteger value,
            String init,
            BigInteger shardingflag,
            String via) {

        return new RawTransaction(
                nonce, gasPrice, gasLimit, "", value, init, null, null, shardingflag, via);
    }

    public static RawTransaction createEtherTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value) {

        return new RawTransaction(
                nonce, gasPrice, gasLimit, to, value, "", null, null, BigInteger.ZERO, null);
    }

    public static RawTransaction createEtherTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            BigInteger shardingflag,
            String via) {

        return new RawTransaction(
                nonce, gasPrice, gasLimit, to, value, "", null, null, shardingflag, via);
    }

    public static RawTransaction createEtherTransaction(
            BigInteger nonce,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            BigInteger gasPremium,
            BigInteger feeCap) {
        return new RawTransaction(
                nonce, null, gasLimit, to, value, "", gasPremium, feeCap, BigInteger.ZERO, null);
    }

    public static RawTransaction createEtherTransaction(
            BigInteger nonce,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            BigInteger gasPremium,
            BigInteger feeCap,
            BigInteger shardingflag,
            String via) {
        return new RawTransaction(
                nonce, null, gasLimit, to, value, "", gasPremium, feeCap, shardingflag, via);
    }

    public static RawTransaction createTransaction(
            BigInteger nonce, BigInteger gasPrice, BigInteger gasLimit, String to, String data) {
        return createTransaction(nonce, gasPrice, gasLimit, to, BigInteger.ZERO, data);
    }

    public static RawTransaction createTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            String data,
            BigInteger shardingflag,
            String via) {
        return createTransaction(
                nonce, gasPrice, gasLimit, to, BigInteger.ZERO, data, shardingflag, via);
    }

    public static RawTransaction createTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            String data) {

        return new RawTransaction(nonce, gasPrice, gasLimit, to, value, data);
    }

    public static RawTransaction createTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            String data,
            BigInteger shardingflag,
            String via) {

        return new RawTransaction(
                nonce, gasPrice, gasLimit, to, value, data, null, null, shardingflag, via);
    }

    public static RawTransaction createTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            String data,
            BigInteger gasPremium,
            BigInteger feeCap) {

        return new RawTransaction(
                nonce,
                gasPrice,
                gasLimit,
                to,
                value,
                data,
                gasPremium,
                feeCap,
                BigInteger.ZERO,
                null);
    }

    public static RawTransaction createTransaction(
            BigInteger nonce,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String to,
            BigInteger value,
            String data,
            BigInteger gasPremium,
            BigInteger feeCap,
            BigInteger shardingflag,
            String via) {

        return new RawTransaction(
                nonce, gasPrice, gasLimit, to, value, data, gasPremium, feeCap, shardingflag, via);
    }

    public BigInteger getNonce() {
        return nonce;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public String getTo() {
        return to;
    }

    public BigInteger getValue() {
        return value;
    }

    public String getData() {
        return data;
    }

    public BigInteger getGasPremium() {
        return gasPremium;
    }

    public BigInteger getFeeCap() {
        return feeCap;
    }

    public BigInteger getShardingflag() {
        return shardingflag;
    }

    public String getVia() {
        return via;
    }

    public boolean isLegacyTransaction() {
        return gasPrice != null && gasPremium == null && feeCap == null;
    }

    public boolean isEIP1559Transaction() {
        return gasPrice == null && gasPremium != null && feeCap != null;
    }
}
